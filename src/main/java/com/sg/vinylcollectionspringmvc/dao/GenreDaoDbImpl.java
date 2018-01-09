/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vinylcollectionspringmvc.dao;

import com.sg.vinylcollectionspringmvc.model.Album;
import com.sg.vinylcollectionspringmvc.model.Genre;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author patri
 */
public class GenreDaoDbImpl implements GenreDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final String SQL_INSERT_GENRE
            = "insert into genres (genreName) values (?)";

    private static final String SQL_INSERT_ALBUMGENRE
            = "insert into albumgenre (albumId, genreId) values (?, ?)";

    private static final String SQL_DELETE_GENRE
            = "delete from genres where genreId = ?";

    private static final String SQL_DELETE_ALBUMGENRE
            = "delete from albumgenre where genreId = ?";

    private static final String SQL_UPDATE_GENRE
            = "update genres set genreName = ? where genreId = ?";

    private static final String SQL_SELECT_ALL_GENRES
            = "select * from genres";

    private static final String SQL_SELECT_GENRE_BY_ID
            = "select * from genres where genreId = ?";

    private static final String SQL_SELECT_ALBUMS_BY_GENREID
            = "select * from albums "
            + "inner join albumgenre on albums.albumId = albumartist.albumId"
            + "inner join genre on genre.genreId = albumgenre.genreId"
            + "where genreId?";

    private static final class GenreMapper implements RowMapper<Genre> {

        @Override
        public Genre mapRow(ResultSet rs, int i) throws SQLException {
            Genre genre = new Genre();
            genre.setGenreName(rs.getString("genreName"));
            genre.setGenreId(rs.getInt("genreId"));
            return genre;
        }

    }

    private static final class AlbumMapper implements RowMapper<Album> {

        @Override
        public Album mapRow(ResultSet rs, int i) throws SQLException {
            Album album = new Album();
            album.setAlbumTitle(rs.getString("albumTitle"));
            album.setAlbumYear(rs.getString("albumYear"));
            album.setAlbumId(rs.getInt("albumId"));
            return album;
        }

    }

    private void insertAlbumGenre(Genre genre) {
        final long genreId = genre.getGenreId();
        final List<Album> albums = genre.getAlbums();

        for (Album currentAlbum : albums) {
            jdbcTemplate.update(SQL_INSERT_ALBUMGENRE,
                    genreId,
                    currentAlbum.getAlbumId());
        }
    }

    private List<Album> findAlbumsForGenre(Genre genre) {
        return jdbcTemplate.query(SQL_SELECT_ALBUMS_BY_GENREID,
                new AlbumMapper(),
                genre.getGenreId());
    }

    private List<Genre>
            associateAlbumsWithGenre(List<Genre> genreList) {
        // set the complete list of album ids for artist
        for (Genre currentGenre : genreList) {
            // add albums to current artist
            currentGenre.setAlbums(findAlbumsForGenre(currentGenre));
        }
        return genreList;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Genre addGenre(Genre genre) {
        jdbcTemplate.update(SQL_INSERT_GENRE,
                genre.getGenreName());
        genre.setGenreId(jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class));
        
        insertAlbumGenre(genre);
        return genre;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void removeGenre(long genreId) {
        jdbcTemplate.update(SQL_DELETE_ALBUMGENRE, genreId);
        jdbcTemplate.update(SQL_DELETE_GENRE, genreId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void updateGenre(Genre genre) {
        jdbcTemplate.update(SQL_UPDATE_GENRE,
                genre.getGenreName(),
                genre.getGenreId());
        
        jdbcTemplate.update(SQL_DELETE_ALBUMGENRE, genre.getGenreId());
        insertAlbumGenre(genre);
    }

    @Override
    public List<Genre> getAllGenres() {
        List<Genre> genreList = jdbcTemplate.query(SQL_SELECT_ALL_GENRES,
                new GenreMapper());
        return associateAlbumsWithGenre(genreList);
    }

    @Override
    public Genre getGenreById(long genreId) {
        try {
            Genre genre = jdbcTemplate.queryForObject(SQL_SELECT_GENRE_BY_ID,
                    new GenreMapper(),
                    genreId);

            genre.setAlbums(findAlbumsForGenre(genre));
            return genre;
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<Genre> searchGenres(Map<Search, String> criteria) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
