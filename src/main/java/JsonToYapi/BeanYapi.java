package JsonToYapi;

import java.util.List;

public class BeanYapi {
    private int index;
    private String name;
    private String desc;
    private int add_time;
    private int up_time;
    List<BeanYapiItem> list;

    public BeanYapi() {
        this.index = 0;
        this.name="公共分类";
        this.desc="公共分类";
        this.add_time=1566268410;
        this.up_time=1566268410;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
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

    public List<BeanYapiItem> getList() {
        return list;
    }

    public void setList(List<BeanYapiItem> list) {
        this.list = list;
    }
}
