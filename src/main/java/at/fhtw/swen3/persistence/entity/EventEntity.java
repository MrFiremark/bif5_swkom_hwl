package at.fhtw.swen3.persistence.entity;

import at.fhtw.swen3.util.JPAUtil;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;

import javax.persistence.*;
import java.awt.*;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class EventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private Date date;

    /*
    @Type(type = "org.hibernate.spatial.GeometryType")
    private Point location;
    */
//    public void createAndStoreEvent(String title, Date theDate, String wktPoint) {
//        Geometry geom = wktToGeometry(wktPoint);
//
//        if (!geom.getGeometryType().equals("Point")) {
//            throw new RuntimeException("Geometry must be a point. Got a " + geom.getGeometryType());
//        }
//
//        EntityManager em = JPAUtil.createEntityManager();
//
//        em.getTransaction().begin();
//
//        EventEntity theEvent = new EventEntity();
//        theEvent.setTitle(title);
//        theEvent.setDate(theDate);
//        theEvent.setLocation((Point) geom);
//        em.persist(theEvent);
//        em.getTransaction().commit();
//        em.close();
//    }
//    private Geometry wktToGeometry(String wktPoint) {
//        WKTReader fromText = new WKTReader();
//        Geometry geom = null;
//        try {
//            geom = fromText.read(wktPoint);
//        } catch (ParseException e) {
//            throw new RuntimeException("Not a WKT string:" + wktPoint);
//        }
//        return geom;
//    }

}
