package com.reactivetest.r2db.admApiDply;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;


import lombok.Builder;
import org.springframework.data.annotation.Id;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
//@Builder
public class AdmApiDply{
    @Id
    private String id;
    private String apiId;
    private String sysId;
    private String apiNm;
    private String ifNo;
    private String ver;
    private List<String> meth;
    private String in;
    private String out;
    private List<String> reqHndlr;
    private List<String> resHndlr;
    private String errHndlr;
    private long timeOut;
    private LocalDateTime dplyDt;
    private String dplyType;


}

