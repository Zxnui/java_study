package JsonToYapi;

import java.util.List;

public class BeanYapiItem {
    private BeanYapiQueryPath query_path;
    private String status;
    private String type;
    private boolean req_body_is_json_schema;
    private boolean res_body_is_json_schema;
    private String method;
    private String title;
    private String path;
    private int project_id;
    private String[] req_params;
    private String res_body_type;
    private int uid;
    private int add_time;
    private int up_time;
    private List<BeanYapiReqQuery> req_query;
    private String res_body;

    public BeanYapiItem() {
        this.status = "undone";
        this.type = "static";
        this.req_body_is_json_schema = true;
        this.res_body_is_json_schema = true;
        this.method = "POST";
        this.project_id = 160;
        this.res_body_type = "raw";
        this.uid = 30;
        this.add_time = 1566268725;
        this.up_time = 1566268809;
    }

    public BeanYapiQueryPath getQuery_path() {
        return query_path;
    }

    public void setQuery_path(BeanYapiQueryPath query_path) {
        this.query_path = query_path;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isReq_body_is_json_schema() {
        return req_body_is_json_schema;
    }

    public void setReq_body_is_json_schema(boolean req_body_is_json_schema) {
        this.req_body_is_json_schema = req_body_is_json_schema;
    }

    public boolean isRes_body_is_json_schema() {
        return res_body_is_json_schema;
    }

    public void setRes_body_is_json_schema(boolean res_body_is_json_schema) {
        this.res_body_is_json_schema = res_body_is_json_schema;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public String[] getReq_params() {
        return req_params;
    }

    public void setReq_params(String[] req_params) {
        this.req_params = req_params;
    }

    public String getRes_body_type() {
        return res_body_type;
    }

    public void setRes_body_type(String res_body_type) {
        this.res_body_type = res_body_type;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getAdd_time() {
        return add_time;
    }

    public void setAdd_time(int add_time) {
        this.add_time = add_time;
    }

    public int getUp_time() {
        return up_time;
    }

    public void setUp_time(int up_time) {
        this.up_time = up_time;
    }

    public List<BeanYapiReqQuery> getReq_query() {
        return req_query;
    }

    public void setReq_query(List<BeanYapiReqQuery> req_query) {
        this.req_query = req_query;
    }

    public String getRes_body() {
        return res_body;
    }

    public void setRes_body(String res_body) {
        this.res_body = res_body;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
