package ru.job4j.tracker;

import java.util.Objects;
/**
 * @author anna brik
 * @version 1
 * @since 02.02.19
 */
public class Item {

    private String id;
    private String name;
    private String desc;
    private long time;
    private String[] comments;

    public Item() {
    }

    public Item(String name, String description, long time) {
        this.name = name;
        this.desc = description;
        this.time = time;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setComments(String[] comments) {
        this.comments = comments;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.desc = description;
    }

    public void setTime(long created) {
        this.time = created;
    }



    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return desc;
    }

    public long getTime() {
        return time;
    }

    public String[] getComments() {
        return comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Item item = (Item) o;
        return time == item.time && Objects.equals(id, item.id) && Objects.equals(name, item.name) && Objects.equals(desc, item.desc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, desc, time);
    }

    @Override
    public String toString() {
        return "ID заявки: " + this.getId() + "Имя заявки:" + this.getName()
                + "Описание заявки:" + this.getDescription() + "Комментарии к заявке:" + this.getComments()
                + "Врмя создания заявки:" + this.getTime() + this.hashCode();
    }
}