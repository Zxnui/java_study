package JsonToYapi;

import java.util.List;

public class BeanApiazzCateGorysApiList {
    private String name;
    private String url;
    private List<BeanApiazzRequest> body_params;
    private String response_example;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<BeanApiazzRequest> getBody_params() {
        return body_params;
    }

    public void setBody_params(List<BeanApiazzRequest> body_params) {
        this.body_params = body_params;
    }

    public String getResponse_example() {
        return response_example;
    }

    public void setResponse_example(String response_example) {
        this.response_example = response_example;
    }
}
