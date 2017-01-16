package com.shmouradko.totalizator.entity;

/**
 * Created by test on 08.01.2017.
 */
public class SportType extends Component implements Comparable<SportType> {
    private String name;
    private String description;

    public SportType(long id, String name, String description){
        super(id);
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        SportType sportType = (SportType) o;
//
//        if (name != null ? !name.equals(sportType.name) : sportType.name != null) return false;
//        return description != null ? description.equals(sportType.description) : sportType.description == null;
//
//    }
//
//    @Override
//    public int hashCode() {
//        int result = name != null ? name.hashCode() : 0;
//        result = 31 * result + (description != null ? description.hashCode() : 0);
//        return result;
//    }
//
//    @Override
//    public String toString() {
//        return "SportType{" +
//                "name='" + name + '\'' +
//                ", description='" + description + '\'' +
//                '}';
//    }

    @Override
    public int compareTo(SportType sportType) {
        return name.compareTo(sportType.getName());
    }
}
