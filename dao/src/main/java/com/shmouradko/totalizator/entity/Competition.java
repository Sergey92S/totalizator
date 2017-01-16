package com.shmouradko.totalizator.entity;

/**
 * Created by Revotech on 13.12.2016.
 */
public class Competition extends Component {
    private String name;
    private String image;
    private String description;
    private String href;

    public Competition(long id, String name, String image, String description, String href){
        super(id);
        this.name = name;
        this.image = image;
        this.description = description;
        this.href = href;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

    public String getHref() {
        return href;
    }

    //    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Competition that = (Competition) o;
//
//        if (name != null ? !name.equals(that.name) : that.name != null) return false;
//        if (image != null ? !image.equals(that.image) : that.image != null) return false;
//        return description != null ? description.equals(that.description) : that.description == null;
//
//    }
//
//    @Override
//    public int hashCode() {
//        int result = name != null ? name.hashCode() : 0;
//        result = 31 * result + (image != null ? image.hashCode() : 0);
//        result = 31 * result + (description != null ? description.hashCode() : 0);
//        return result;
//    }
//
//    @Override
//    public String toString() {
//        return "Competition{" +
//                "name='" + name + '\'' +
//                ", image='" + image + '\'' +
//                ", description='" + description + '\'' +
//                '}';
//    }
}
