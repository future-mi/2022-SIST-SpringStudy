package com.sist.music.vo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MusicVO {
    private int no, cno, idcrement;
    private String title, singer, album, state, poster, mkey;
}