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
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

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

    @Override
    public GenreDao addGenre(Genre genre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeGenre(long genreId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateGenre(Genre genre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<GenreDao> getAllGenres() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Genre getGenreById(long genreId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Genre> searchGenres(Map<Search, String> criteria) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
