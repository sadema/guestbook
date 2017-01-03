package nl.kristalsoftware.guestbook.guest;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by sjoerdadema on 03/01/2017.
 */
@RequestScoped
@Transactional
public class GuestService {

    @PersistenceContext
    EntityManager em;

    public GuestEntry save(GuestEntry entry) {
        return this.em.merge(entry);
    }

    public List<GuestEntry> all() {
        return this.em.createNamedQuery(GuestEntry.findAll, GuestEntry.class).getResultList();
    }

    public GuestEntry find(long id) {
        return this.em.find(GuestEntry.class, id);
    }

}
