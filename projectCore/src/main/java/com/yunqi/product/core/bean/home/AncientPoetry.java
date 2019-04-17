package com.yunqi.product.core.bean.home;

/**
 * @author zhouxiang
 * @package com.yunqi.product.core.bean.home
 * @fileName AncientPoetry
 * @date or  2019/4/17 下午5:20
 * @describe TODO
 */
public class AncientPoetry {
//    title 七言记德诗三十首谨献司徒相公 陈情
//    content 俗眼难窥冰雪姿，终朝共咏小山词。|此身依托同鸡犬，他日升天莫弃遗。|（按以上三十首诗见《桂苑笔耕集》第十七卷，前有《献诗启》，略谓：“如某者，迹自外方，艺唯下品。|虽儒宫慕善，每尝窥颜冉之墙，而笔阵争雄，未得摩曹刘之垒。|但以幸游乐国，获睹仁风，久贮恳诚，冀伸歌咏，辄献纪德绝句诗三十首，谨封如别。|”）-312-。
//    authors 崔致远
    String title;
    String content;
    String authors;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "TestRankingBean{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", authors='" + authors + '\'' +
                '}';
    }
}
