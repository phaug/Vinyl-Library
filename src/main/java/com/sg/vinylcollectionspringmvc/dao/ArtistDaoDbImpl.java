/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vinylcollectionspringmvc.dao;

import com.sg.vinylcollectionspringmvc.model.Album;
import com.sg.vinylcollectionspringmvc.model.Artist;
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
public class ArtistDaoDbImpl implements ArtistDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public static final String SQL_INSERT_ARTIST
            = "insert into artists (artistName) "
            + "values (?)";

    private static final String SQL_INSERT_ALBUMARTIST
            = "insert into albumartist (albumId, artistId) values (?, ?)";

    public static final String SQL_DELETE_ARTIST
            = "delete from artists where artistId = ?";

    public static final String SQL_DELETE_ALBUMARTIST
            = "delete from albumartist where artistId = ?";

    public static final String SQL_UPDATE_ARTIST
            = "update artists set artistName = ? where artistId = ?";

    public static final String SQL_SELECT_ALL_ARTISTS
            = "select * from artists";

    private static final String SQL_SELECT_ARTIST_BY_ID
            = "select * from artists where artistId = ?";
    
    private static final String SQL_SELECT_ALBUMS_BY_ARTISTID
            ="select * from albums "
            + "inner join albumartist on albums.albumId = albumartist.albumId"
            + "inner join artist on artist.artistId = albumartist.artistId"
            + "where artistId = ?";

    private static final class ArtistMapper implements RowMapper<Artist> {

        @Override
        public Artist mapRow(ResultSet rs, int i) throws SQLException {
            Artist artist = new Artist();
            artist.setArtistName(rs.getString("artistName"));
            artist.setArtistId(rs.getInt("artistId"));
            return artist;
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

    private void insertAlbumArtist(Artist artist) {
        final long artistId = artist.getArtistId();
        final List<Album> albums = artist.getAlbums();

        for (Album currentAlbum : albums) {
            jdbcTemplate.update(SQL_INSERT_ALBUMARTIST,
                    artistId,
                    currentAlbum.getAlbumId());
        }
    }

    private List<Album> findAlbumsForArtist(Artist artist) {
        return jdbcTemplate.query(SQL_SELECT_ALBUMS_BY_ARTISTID,
                new AlbumMapper(),
                artist.getArtistId());
    }

    private List<Artist>
            associateAlbumsWithArtist(List<Artist> artistList) {
        // set the complete list of album ids for artist
        for (Artist currentArtist : artistList) {
            // add albums to current artist
            currentArtist.setAlbums(findAlbumsForArtist(currentArtist));
        }
        return artistList;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Artist addArtist(Artist artist) {
        jdbcTemplate.update(SQL_INSERT_ARTIST,
                artist.getArtistName());
        artist.setArtistId(jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class));

        insertAlbumArtist(artist);
        return artist;

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void removeArtist(long artistId) {
        jdbcTemplate.update(SQL_DELETE_ALBUMARTIST, artistId);
        jdbcTemplate.update(SQL_DELETE_ARTIST, artistId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void updateArtist(Artist artist) {
        jdbcTemplate.update(SQL_UPDATE_ARTIST,
                artist.getArtistName(),
                artist.getArtistId());

        jdbcTemplate.update(SQL_DELETE_ALBUMARTIST, artist.getArtistId());
        insertAlbumArtist(artist);
    }

    @Override
    public List<Artist> getAllArtists() {
        List<Artist> artistList = jdbcTemplate.query(SQL_SELECT_ALL_ARTISTS,
                new ArtistMapper());
        return associateAlbumsWithArtist(artistList);
    }

    @Override
    public Artist getArtistById(long artistId) {
        try {
            Artist artist = jdbcTemplate.queryForObject(SQL_SELECT_ARTIST_BY_ID,
                    new ArtistMapper(),
                    artistId);

            artist.setAlbums(findAlbumsForArtist(artist));
            return artist;
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<Artist> searchArtists(Map<Search, String> criteria) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
