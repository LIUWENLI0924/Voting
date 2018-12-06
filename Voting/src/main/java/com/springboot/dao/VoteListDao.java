package com.springboot.dao;

import com.springboot.pojo.Item;
import com.springboot.pojo.Options;
import com.springboot.pojo.Subject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VoteListDao {
    /**
     *查询
     * @return
     */
    public List<Subject> getVote(@Param("title") String title);
    /**
     *根据id查询content
     * @return
     */
    public List<Options> getContent(@Param("sid") int sid);
    /**
     *根据id查询
     * @return
     */
    public Subject getVoteById(@Param("sid") int sid);

    /**
     * 新增投票
     * @param i
     * @return
     */
    public int voteAdd(Item i);

    /**
     * 判断是否投过票
     * @param i
     * @return
     */
    public int isVote(Item i);

    /**
     * 根据sid查询oid
     * @param osid
     * @return
     */
    public List<Options> getOid(int osid);

    /**
     * 查询票数
     * @param i
     * @return
     */
    public int voteNum(Item i);

    /**
     * 新增subject表
     * @param s
     * @return
     */
    public int subAdd(Subject s);

    /**
     * 新增Options表
     * @param o
     * @return
     */
    public int optAdd(Options o);

    /**
     * 根据主题查询sid
     * @param title
     * @return
     */
    public int getSid(String title);

    /**
     *根据sid删除subject表
     * @param sid
     * @return
     */
    public int delSub(int sid);

    /**
     * 根据sid删除options表
     * @param osid
     * @return
     */
    public int delOpt(int osid);

    /**
     * 根据sid删除item表
     * @param sid
     * @return
     */
    public int delItem(int sid);
    /**
     * 根据sid修改subject
     * @param s
     * @return
     */
    public int updSub(Subject s);

    /**
     * 根据sid修改options
     * @param o
     * @return
     */
    public int updOpt(Options o);

    /**
     * 根据osid查询原本有几条数据
     * @param osid
     * @return
     */
    public List<Options> contOp(int osid);

    /**
     * 查询数据库里本来的oid
     * @return
     */
    public  List<Options> getOids();

    /**
     * 查询本来的content
     * @param osid
     * @return
     */
    public Options getcontentss(int osid);

    /**
     * 删除选项
     * @param oid
     * @return
     */
    public int delById(int oid);
}
