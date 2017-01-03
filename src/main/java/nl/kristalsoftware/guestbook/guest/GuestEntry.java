package nl.kristalsoftware.guestbook.guest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by sjoerdadema on 02/01/2017.
 */
@Entity
@NamedQuery(name = GuestEntry.findAll, query = "SELECT g FROM GuestEntry g")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class GuestEntry {

    public final static String findAll = "GuestEntry.findAll";

    @Id
    @GeneratedValue
    private long id;

    private String content;

    public GuestEntry(String content) {
        this.content = content;
    }

    protected GuestEntry() {}

    public long getId() {
        return id;
    }

}
