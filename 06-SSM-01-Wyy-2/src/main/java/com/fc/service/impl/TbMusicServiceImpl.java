package com.fc.service.impl;

import com.fc.dao.TbMusicMapper;
import com.fc.entity.TbMusic;
import com.fc.entity.TbMusicExample;
import com.fc.service.TbMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TbMusicServiceImpl implements TbMusicService {
    @Autowired
    private TbMusicMapper musicMapper;

    @Override
    public List<TbMusic> findAll() {
        return musicMapper.selectByExample(null);
    }

    @Override
    public TbMusic findById(Integer musicId) {
        return musicMapper.selectByPrimaryKey(musicId);
    }

    @Override
    public TbMusic prevSong(Integer musicId) {
        if (musicId != 1) {
            musicId--;
        } else {
            musicId = musicMapper.findMaxId();
        }
        return musicMapper.selectByPrimaryKey(musicId);
    }

    @Override
    public TbMusic nextSong(Integer musicId) {
        if (musicId != musicMapper.findMaxId()) {
            musicId++;
        } else {
            musicId = 1;
        }
        return musicMapper.selectByPrimaryKey(musicId);
    }

    @Override
    public List<TbMusic> search(String keyword) {
        TbMusicExample musicExample = new TbMusicExample();

        TbMusicExample.Criteria criteria = musicExample.createCriteria();

        criteria.andMusicNameLike("%" + keyword + "%");

        return musicMapper.selectByExample(musicExample);
    }
}
