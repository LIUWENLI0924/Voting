package com.springboot.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.springboot.dao.VoteListDao;
import com.springboot.pojo.Item;
import com.springboot.pojo.Options;
import com.springboot.pojo.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VoteListServiceImpl implements VoteListService{
    @Autowired
    private VoteListDao vd;
    @Override
    public Page<Object> getVote(String title,int pageIndex,int pageSize) {
        Page<Object> page= PageHelper.startPage(pageIndex,pageSize);
        vd.getVote(title);
        return page;
    }

    @Override
    public List<Options> getContent(int sid) {
        return vd.getContent(sid);
    }

    @Override
    public Subject getVoteById(int sid) {
        return vd.getVoteById(sid);
    }

    @Override
    public int voteAdd(Item i) {
        return vd.voteAdd(i);
    }

    @Override
    public int isVote(Item i) {
        return vd.isVote(i);
    }

    @Override
    public List<Options> getOid(int osid) {
        return vd.getOid(osid);
    }

    @Override
    public int voteNum(Item i) {
        return vd.voteNum(i);
    }

    @Override
    public int subAdd(Subject s) {
        return vd.subAdd(s);
    }

    @Override
    public int optAdd(Options o) {
        return vd.optAdd(o);
    }

    @Override
    public int getSid(String title) {
        return vd.getSid(title);
    }

    @Override
    public int delSub(int sid) {
        return vd.delSub(sid);
    }

    @Override
    public int delOpt(int osid) {
        return vd.delOpt(osid);
    }

    @Override
    public int delItem(int sid) {
        return vd.delItem(sid);
    }

    @Override
    public int updSub(Subject s) {
        return vd.updSub(s);
    }

    @Override
    public int updOpt(Options o) {
        return vd.updOpt(o);
    }

    @Override
    public List<Options> contOp(int osid) {
        return vd.contOp(osid);
    }

    @Override
    public List<Options> getOids() {
        return vd.getOids();
    }

    @Override
    public int delById(int oid) {
        return vd.delById(oid);
    }


}
