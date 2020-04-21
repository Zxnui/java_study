package JsonToYapi;

import com.alibaba.fastjson.JSON;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class main {

    public static void main(String[] args) throws IOException {
        List<BeanYapi> api = new ArrayList<BeanYapi>();
        BeanYapi one = new BeanYapi();
        List<BeanYapiItem> two = new ArrayList<BeanYapiItem>();

        String json = FileUtil.readFile();
        BeanApiazz apiazz = JSON.parseObject(json,BeanApiazz.class);

        List<BeanApiazzCateGorys> cateGorys = apiazz.getCategorys();
        for(BeanApiazzCateGorys cateGory : cateGorys){
            List<BeanApiazzCateGorysApiList> apiazzCateGorysApiLists  = cateGory.getApi_list();
            for (BeanApiazzCateGorysApiList list : apiazzCateGorysApiLists){
                List<BeanYapiReqQuery> four = new ArrayList<BeanYapiReqQuery>();
                BeanYapiItem item = new BeanYapiItem();
                BeanYapiQueryPath three = new BeanYapiQueryPath();
                three.setPath(list.getUrl());
                item.setQuery_path(three);

                item.setTitle(cateGory.getName()+"-"+list.getName());
                item.setPath(list.getUrl());
                item.setRes_body(list.getResponse_example());


                for (BeanApiazzRequest request : list.getBody_params()){
                    BeanYapiReqQuery req = new BeanYapiReqQuery();
                    req.setExample("");
                    req.setName(request.getKey());
                    req.setDesc(request.getDesc());
                    four.add(req);
                }

                item.setReq_query(four);
                two.add(item);
            }
        }

        one.setList(two);
        api.add(one);
        String jsonres = JSON.toJSONString(api);
        FileUtil.writeFile(jsonres);
    }
}
