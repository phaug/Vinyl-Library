/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vinylcollectionspringmvc.dao;

import com.sg.vinylcollectionspringmvc.model.Album;
import com.sg.vinylcollectionspringmvc.model.Artist;
import com.sg.vinylcollectionspringmvc.model.Genre;
import com.sg.vinylcollectionspringmvc.model.Musician;
import com.sg.vinylcollectionspringmvc.model.Song;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author patri
 */
public class AlbumDaoDbImpl implements AlbumDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public static final String SQL_INSERT_ALBUM
            = "insert into albums (albumTitle, albumYear) "
            + "values (?, ?)";

    private static final String SQL_INSERT_ALBUMARTIST
            = "insert into albumartist (albumId, artistId) values (?, ?)";

    private static final String SQL_INSERT_ALBUMGENRE
            = "insert into albumgenre (albumId, genreId) values (?, ?)";

    private static final String SQL_INSERT_ALBUMSONG
            = "insert into albumsong (albumId, songId) values (?, ?)";

    private static final String SQL_INSERT_ALBUMMUSICIAN
            = "insert into albummusician (albumId, musicianId) values (?, ?)";

    public static final String SQL_DELETE_ALBUM
            = "delete from albums where albumId = ?";

    public static final String SQL_DELETE_ALBUMARTIST
            = "delete from albumartist where albumId = ?";

    private static final String SQL_DELETE_ALBUMGENRE
            = "delete from albumgenre where albumId = ?";

    private static final String SQL_DELETE_ALBUMSONG
            = "delete from albumsong where albumId = ?";

    private static final String SQL_DELETE_ALBUMMUSICIAN
            = "delete from albummusician where albumId = ?";

    public static final String SQL_UPDATE_ALBUM
            = "update artists set albumTitle = ?, albumYear = ? where artistId = ?";

    public static final String SQL_SELECT_ALL_ALBUMS
            = "select * from albums";

    private static final String SQL_SELECT_ARTIST_BY_ID
            = "select * from albums where albumId = ?";

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

    private void insertAlbumArtist(Album album) {
        final long albumId = album.getAlbumId();
        final List<Artist> artists = album.getArtist();

        for (Artist currentArtist : artists) {
            jdbcTemplate.update(SQL_INSERT_ALBUMARTIST,
                    albumId,
                    currentArtist.getArtistId());
        }
    }

    private void insertAlbumGenre(Album album) {
        final long albumId = album.getAlbumId();
        final List<Genre> genres = album.getGenre();

        for (Genre currentGenre : genres) {
            jdbcTemplate.update(SQL_INSERT_ALBUMGENRE,
                    albumId,
                    currentGenre.getGenreId());
        }
    }

    private void insertAlbumMusician(Album album) {
        final long albumId = album.getAlbumId();
        final List<Musician> musicians = album.getMusicians();

        for (Musician currentMusician : musicians) {
            jdbcTemplate.update(SQL_INSERT_ALBUMMUSICIAN,
                    albumId,
                    currentMusician.getMusicianId());
        }
    }

    private void insertAlbumSong(Album album) {
        final long albumId = album.getAlbumId();
        final List<Song> songs = album.getSongs();

        for (Song currentSong : songs) {
            jdbcTemplate.update(SQL_INSERT_ALBUMSONG,
                    albumId,
                    currentSong.getSongId());
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Album addAlbum(Album album) {
        jdbcTemplate.update(SQL_INSERT_ALBUM,
                album.getAlbumTitle(),
                album.getAlbumYear());
        album.setAlbumId(jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class));
        
        insertAlbumArtist(album);
        insertAlbumGenre(album);
        insertAlbumMusician(album);
        insertAlbumSong(album);
        return album;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void removeAlbum(long albumId) {
        jdbcTemplate.update(SQL_DELETE_ALBUMARTIST);
        jdbcTemplate.update(SQL_DELETE_ALBUMGENRE);
        jdbcTemplate.update(SQL_DELETE_ALBUMSONG);
        jdbcTemplate.update(SQL_DELETE_ALBUMMUSICIAN);
        jdbcTemplate.update(SQL_DELETE_ALBUM);

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void updateAlbum(Album album) {
        jdbcTemplate.update(SQL_UPDATE_ALBUM,
                album.getAlbumTitle(),
                album.getAlbumYear());
        
        jdbcTemplate.update(SQL_DELETE_ALBUMARTIST, album.getAlbumId());
        insertAlbumArtist(album);
        jdbcTemplate.update(SQL_DELETE_ALBUMGENRE, album.getAlbumId());
        insertAlbumGenre(album);
        jdbcTemplate.update(SQL_DELETE_ALBUMMUSICIAN, album.getAlbumId());
        insertAlbumMusician(album);
        jdbcTemplate.update(SQL_DELETE_ALBUMSONG, album.getAlbumId());
        insertAlbumSong(album);
    }

    @Override
    public List<Album> getAllAlbums() {
        List<Album> albumList = jdbcTemplate.query(SQL_SELECT_ALL_ALBUMS, 
                new AlbumMapper());
        return albumList;
    }

    @Override
    public Album getAlbumById(long albumId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Album> searchAlbums(Map<Search, String> criteria) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
