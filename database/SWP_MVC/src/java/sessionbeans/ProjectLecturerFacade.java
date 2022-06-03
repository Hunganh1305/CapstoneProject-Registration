/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entities.ProjectLecturer;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author SE161740 Pham Nguyen Hung Anh
 */
@Stateless
public class ProjectLecturerFacade extends AbstractFacade<ProjectLecturer> {

    @PersistenceContext(unitName = "SWPPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProjectLecturerFacade() {
        super(ProjectLecturer.class);
    }
    
}
