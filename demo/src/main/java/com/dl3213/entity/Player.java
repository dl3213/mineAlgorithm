package com.dl3213.entity;

public class Player {
    
    private String _id;
    private Integer pid;
    private String pname;
    private Integer psycho_pass;
    public String get_id() {
        return _id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }
    public Integer getPid() {
        return pid;
    }
    public void setPid(Integer pid) {
        this.pid = pid;
    }
    public String getPname() {
        return pname;
    }
    public void setPname(String pname) {
        this.pname = pname;
    }
    public Integer getPsycho_pass() {
        return psycho_pass;
    }
    public void setPsycho_pass(Integer psycho_pass) {
        this.psycho_pass = psycho_pass;
    }
    @Override
    public String toString() {
        return "Player [_id=" + _id + ", pid=" + pid + ", pname=" + pname + ", psycho_pass=" + psycho_pass + "]";
    }
    public Player() {
        super();
    }
    public Player(String _id, Integer pid, String pname, Integer psycho_pass) {
        super();
        this._id = _id;
        this.pid = pid;
        this.pname = pname;
        this.psycho_pass = psycho_pass;
    }

    
}
