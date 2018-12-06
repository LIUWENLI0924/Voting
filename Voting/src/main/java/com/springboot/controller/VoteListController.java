package com.springboot.controller;


import com.github.pagehelper.Page;
import com.springboot.pojo.Item;
import com.springboot.pojo.Options;
import com.springboot.pojo.Subject;
import com.springboot.service.UserServiceImpl;
import com.springboot.service.VoteListServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
/**
 * votelist
 * @author acer
 *
 */
@Controller
public class VoteListController {
    @Autowired
    private VoteListServiceImpl vs;
    @Autowired
    private UserServiceImpl us;
    @RequestMapping("/getVote")
    public String getVote(String title,HttpSession session,int pageIndex){
        getAll(title,session,pageIndex);
        return "votelist";
    }
    public void getAll(String title,HttpSession session,int pageIndex){
        Page<Object> list=vs.getVote(title,pageIndex,2);
        session.setAttribute("list",list);
    }

    /**
     * 根据id查数据
     * @param sid
     * @param mo
     */
    public void sel(int sid, Model mo){
        Subject sub=vs.getVoteById(sid);
        mo.addAttribute("sub",sub);
        List<Options> con=vs.getContent(sid);
        mo.addAttribute("su",con);
    }
    @RequestMapping("/getVoteById")
    public String getVoteById(int sid, Model mo){
        sel(sid,mo);
        return "vote";
    }
    @RequestMapping("/voteAdd")
    public String  voteAdd(int uid,int sid,int[] oid,HttpSession session){
        Item i=new Item();
        i.setUid(uid);
        i.setSid(sid);
        int row=vs.isVote(i);
        if(row>0){
            session.setAttribute("meg","该用户已经投票，不能重复投票");
            return "Vote-voteSave.html";
        }
        for (int o:oid) {
            i.setOid(o);
            vs.voteAdd(i);
        }
        return "forward:/getVote?pageIndex=1";
    }
    public void sel(int sid, Model mo,HttpSession session){
        Subject sub=vs.getVoteById(sid);
        mo.addAttribute("sub",sub);
        List<Options> oids=vs.getContent(sid);
        oids=vs.getOid(sid);
        Item i=new Item();
        i.setSid(sid);
        for (Options o:oids) {
            i.setOid(o.getOid());
            o.setVoteNum(vs.voteNum(i));
            mo.addAttribute("oids",oids);
        }
    }
    @RequestMapping("/selVoteById")
    public String selVoteById(int sid, Model mo,HttpSession session){
        sel(sid,mo,session);
        return "voteview";
    }

    /**
     * 新增投票
     * @param s
     * @return
     */
    @RequestMapping("/addVote")
    public String addVote(Subject s,String[]contents,Model m,HttpSession session){
        int row=vs.subAdd(s);
        int sid=vs.getSid(s.getTitle());
        Options o=new Options();
        o.setOsid(sid);
        for (String con:contents
             ) {
            o.setContent(con);
            vs.optAdd(o);
        }


        return "forward:/getVote?pageIndex=1";
    }
    @RequestMapping("del")
    public String del(int sid){
        vs.delSub(sid);
        vs.delItem(sid);
        vs.delOpt(sid);
        return "forward:/getVote?pageIndex=1";
    }
    @RequestMapping("/isaaa")
    public String isaaa(String username,HttpSession session){
        int row=us.isAdmin(username);
        if(row==0){
            session.setAttribute("meg","用户权限不足，请联系管理员！");
            return "Vote-voteSave";
        }
        return "forward:/weihu?pageIndex=1";
    }
    @RequestMapping("weihu")
    public String weihu(String title,HttpSession session,int pageIndex){
       getAll(title,session,pageIndex);
        return "weihu";
    }

   @RequestMapping("upd")
   public String upd(Subject s,int[]oid,String[]content){
       int row=vs.updSub(s);//修改单选按钮
      /* List<Options> cont=vs.contOp(s.getSid());
       System.out.println("原本有几条数据:"+cont.size());
        if(cont.size()>oid.length){
            for (int i=oid.length;i<cont.size();i++){

            }

        }*/
       for (int i=0;i<oid.length;i++){//修改
           Options o=new Options();
           o.setOsid(s.getSid());
           o.setContent(content[i]);
           o.setOid(oid[i]);
           vs.updOpt(o);
       }
       for (int i=oid.length;i<content.length;i++){//新增
           Options o=new Options();
           o.setOsid(s.getSid());
           o.setContent(content[i]);
           vs.optAdd(o);
       }
      /* if(content.length>cont.size()){//新增
               int row3= vs.optAdd(o);
               System.out.println("row3"+row3);
       }else if(content.length==cont.size()){
           for(int i=0;i<oid.length;i++){
               o.setOid(oid[i]);
               int row2=vs.updOpt(o);
               System.out.println("修改"+row2);
           }
       }*/
       return "forward:/getVote?pageIndex=1";
   }
    @RequestMapping("selById")
    public String selById(int sid, Model mo){
        sel(sid,mo);
        return "modify";
    }




    @PostMapping("/delById")
    @ResponseBody
    public int delById(int oid){

      return  vs.delById(oid);
    }


    @RequestMapping("/add")
    public String add(String username,HttpSession session){
        int row=us.isAdmin(username);
        if(row==0){
            session.setAttribute("meg","用户权限不足，请联系管理员！");
            return "Vote-voteSave";
        }
        return "add";
    }

}
