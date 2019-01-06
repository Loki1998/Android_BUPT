package cui.bupt.showapp;

import java.util.ArrayList;
import java.util.List;
public class Comic {
    private String name;
    private int imageId;
    private String desc;
//构造函数
    public Comic(String name, int imageId, String desc) {
        this.name = name;
        this.imageId = imageId;
        this.desc = desc;
    }

// 返回一个 Comic 的列表
    public static List<Comic> getAllComics() {
        List<Comic> comics = new ArrayList<Comic>();
        comics.add(new Comic("海贼王", R.drawable.one_piece, "时值“大海贼时代”，为了寻找传说中海贼王罗杰所留下的大秘宝“ONE PIECE”，无数海贼扬起旗帜，互相争斗。有一个梦想成为海盗的少年叫路飞，他因误食“恶魔果实”而成为了橡皮人，在获得超人能力的同时付出了一辈子无法游泳的代价。十年后，路飞为实现与因救他而断臂的香克斯的约定而出海，他在旅途中不断寻找志同道合的伙伴，开始了以成为海贼王为目标的伟大的冒险旅程"));
        comics.add(new Comic("一人之下", R.drawable.under_one_person, "随着爷爷尸体被盗，神秘少女冯宝宝的造访，少年张楚岚的平静校园。急于解开爷爷和自身秘密的张楚岚和没有任何记忆“不死少女”冯宝宝开启了“异人”之旅"));
        comics.add(new Comic("寄生兽", R.drawable.parasyte
                , "故事講述某天於地球上空出現無數孢子，從孢子中誕生的幼蟲侵入身體後，游向腦部並進行寄生，完成後便與腦部細胞同化。被寄生後頭部能任意變形，其食物是與宿主相同的物種—人類。由於寄生生物的出現，殘忍的「碎屍殺人事件」頻傳，但人類卻欠缺警覺性地忽視這些慘案，而隨著寄生生物逐漸了解人類世界，他們也學會了計劃組織並利用政治的權柄保障自己族類的生存，世界的未來陷入無盡的恐慌中。主角泉新一是被寄生生物寄生的人類之一，但是由於入侵失敗，寄生在他體內的生物並沒有與他的腦合體，而是在他的右手中便已成熟。為了被寄生生物殺死的母親以及所有人類的未來，展開了一系列與其他完全體寄生生物的殊死搏鬥。"));

        return comics;

    }

// 以下都是访问内部属性的 getter 和 setter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}

