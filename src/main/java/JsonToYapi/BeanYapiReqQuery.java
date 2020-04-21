package JsonToYapi;

public class BeanYapiReqQuery {
    private String required;
    private String name;
    private String example;
    private String desc;

    public BeanYapiReqQuery() {
        this.required = "1";
    }

    public String getRequired() {
        return required;
    }

    public void setRequired(String required) {
        this.required = required;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
