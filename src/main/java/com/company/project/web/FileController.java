package com.company.project.web;

import com.alibaba.fastjson.JSONObject;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.sun.net.httpserver.HttpContext;
import org.apache.commons.codec.binary.Base64;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.*;

@RestController
public class FileController {
    @PostMapping("/upload")
    /*public void upload(String imgDatas, String id, String picNum) {

        String imgDatas= json.getString("userid");
        String id= json.getString("id");
        String picNum = json.getString("imgDatas");
        String src=null;

        try {
            src= ImgBase64Decoder.photo(imgDatas, id, picNum);

        } catch (Exception e) {

        }
        return ResultGenerator.genSuccessResult();;

    }*/
    public Result addWtfk(@RequestBody Map<String,String> map){
        Result result = new Result();
        String imgFilePath=null;
        List<String> list = new ArrayList<String>();
        try {
            //System.out.println(map.get("content"));
            JSONObject j = JSONObject.parseObject(map.get("arrayObj"));
            Set<String> jsonSet = j.keySet();
            Iterator<String> iterator = jsonSet.iterator();
            while (iterator.hasNext()){
                //通过迭代器可以取到外部json的key
                String json = iterator.next();
                //取得内部json字符串
                String string = j.getString(json);
                String base = string.replace("data:image/jpeg;base64,", "");
                System.out.println(base);
                String s = UUID.randomUUID().toString();
                imgFilePath = "C:\\Users\\Zhang\\Documents\\HBuilderProject\\午托\\images\\" + s + ".jpg";
                String path = "images/"+ s + ".jpg";
                list.add(path);
                OutputStream out = new FileOutputStream(imgFilePath);
                out.write(Base64.decodeBase64(base));
                out.flush();
                out.close();
            }
        } catch (Exception e) {
            return ResultGenerator.genFailResult(e.getMessage());
        }
        return ResultGenerator.genSuccessResult(list);
    }
}
