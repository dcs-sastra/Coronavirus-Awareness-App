package dsc.sastra.coronavirus_awareness_app.newsdata;
public class News { private String Title,Content,Image;
    public News(String Title , String Content,String Image ){
        this.Content = Content;
        this.Title = Title;
        this.Image = Image; }
        public News(){}
public String getTitle(){
        return Title;
}
public String getContent(){
        return Content;
}
public String getImage(){return Image;}
public void setTitle(String title){
        Title = title;
}
public void setContent(String content){
        Content = content;
}
public void setImage(String image){
        Image =image;
}
}
