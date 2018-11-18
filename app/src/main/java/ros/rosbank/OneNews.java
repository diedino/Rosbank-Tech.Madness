package ros.rosbank;

import android.widget.ImageView;

public class OneNews {
    private String header;
    private String from;
    private String shortInfo;
    private String textMesssage;
    private int iconResource;

    public OneNews(String header, String from,String shortInfo, String textMesssage, int iconResource) {
        this.header = header;
        this.from=from;
        this.shortInfo = shortInfo;
        this.textMesssage = textMesssage;
        this.iconResource = iconResource;
    }

    public String getFrom(){return this.from;}
    public void setFrom(String from){this.from=from;}
    public String getTextMesssage() {return this.textMesssage;}
    public void setTextMesssage(String textMesssage){this.textMesssage = textMesssage;}
    public String getHeader(){
        return this.header;
    }
    public String getShortInfo(){
        return this.shortInfo;
    }
    public int getIconResource(){
        return this.iconResource;
    }
    public void setHeader(String header){
        this.header = header;
    }
    public void setShortInfo(String shortInfo){
        this.shortInfo = shortInfo;
    }
    public void setIconResource(int iconResource){
        this.iconResource = iconResource;
    }
}
