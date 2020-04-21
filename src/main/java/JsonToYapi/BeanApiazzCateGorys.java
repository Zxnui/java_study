package JsonToYapi;

import java.util.List;

public class BeanApiazzCateGorys {
    private String id;
    private String name;
    private String comment;
    private String rank;
    private String parent_category_id;
    private List<BeanApiazzCateGorysApiList> api_list;
    private String[] sub_categorys;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getParent_category_id() {
        return parent_category_id;
    }

    public void setParent_category_id(String parent_category_id) {
        this.parent_category_id = parent_category_id;
    }

    public List<BeanApiazzCateGorysApiList> getApi_list() {
        return api_list;
    }

    public void setApi_list(List<BeanApiazzCateGorysApiList> api_list) {
        this.api_list = api_list;
    }

    public String[] getSub_categorys() {
        return sub_categorys;
    }

    public void setSub_categorys(String[] sub_categorys) {
        this.sub_categorys = sub_categorys;
    }
}
