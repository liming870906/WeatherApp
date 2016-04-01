package cn.com.tarena.weatherapp.entity;

/**
 *  生活指数实体类
 */
public class LiftEntity {
    private int[] icons;
    private String[] texts;

    public LiftEntity(int[] icons, String[] texts) {
        this.icons = icons;
        this.texts = texts;
    }
}
