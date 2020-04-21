package JsonToYapi;

import java.util.List;

public class BeanApiazz {
    private BeanApiazzProjectInfo project_info;
    private List<BeanApiazzCateGorys> categorys;
    private String[] envirnments;
    private String[] status_codes;
    private String[] requset_paramdocs;
    private String[] response_models;
    private String[] tester_flows;
    private String version;

    public BeanApiazzProjectInfo getProject_info() {
        return project_info;
    }

    public void setProject_info(BeanApiazzProjectInfo project_info) {
        this.project_info = project_info;
    }

    public String[] getEnvirnments() {
        return envirnments;
    }

    public void setEnvirnments(String[] envirnments) {
        this.envirnments = envirnments;
    }

    public String[] getStatus_codes() {
        return status_codes;
    }

    public void setStatus_codes(String[] status_codes) {
        this.status_codes = status_codes;
    }

    public String[] getRequset_paramdocs() {
        return requset_paramdocs;
    }

    public void setRequset_paramdocs(String[] requset_paramdocs) {
        this.requset_paramdocs = requset_paramdocs;
    }

    public String[] getResponse_models() {
        return response_models;
    }

    public void setResponse_models(String[] response_models) {
        this.response_models = response_models;
    }

    public String[] getTester_flows() {
        return tester_flows;
    }

    public void setTester_flows(String[] tester_flows) {
        this.tester_flows = tester_flows;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<BeanApiazzCateGorys> getCategorys() {
        return categorys;
    }

    public void setCategorys(List<BeanApiazzCateGorys> categorys) {
        this.categorys = categorys;
    }
}
