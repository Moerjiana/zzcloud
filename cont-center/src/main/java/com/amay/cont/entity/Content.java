package com.amay.cont.entity;

import java.io.Serializable;

/**
 * (Content)实体类
 *
 * @author makejava
 * @since 2020-07-28 15:51:05
 */
public class Content implements Serializable {
    private static final long serialVersionUID = -16421579495035669L;

    private Integer contId;

    private String dialogue;

    private String audio;

    private Integer leftId;

    private String roleName;

    private String script;


    public Integer getContId() {
        return contId;
    }

    public void setContId(Integer contId) {
        this.contId = contId;
    }

    public String getDialogue() {
        return dialogue;
    }

    public void setDialogue(String dialogue) {
        this.dialogue = dialogue;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }

    public Integer getLeftId() {
        return leftId;
    }

    public void setLeftId(Integer leftId) {
        this.leftId = leftId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }

}