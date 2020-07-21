package com.example.transientbehaviour;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

@Service
public class EntityService {

    @Autowired
    public DummyEntityRepository dummyEntityRepository;

    @Autowired
    EntityManager em;

    @PostConstruct
    public void init() {
        dummyEntityRepository.save(new DummyEntity(1l,"dummy1", null));
        dummyEntityRepository.save(new DummyEntity(2l, "dummy2", null));
    }

    @Transactional
    public void mergeBehaviourUnManagedEntity(){
        DummyEntity unManaged = new DummyEntity(1l,"dummy-updated", "transient");
        System.out.println("Before Merge : Unmanaged with TransientField value of : " + unManaged.getTransientField());
        DummyEntity managed = em.merge(unManaged);
        System.out.println("After Merge : Managed with TransientField value of : " + managed.getTransientField());
    }

    @Transactional
    public void mergeBehaviourManagedEntity(){
        DummyEntity managedBeforeMerge = em.find(DummyEntity.class, 1l);
        managedBeforeMerge.setTransientField("transient");
        managedBeforeMerge.setName("Updated name");
        System.out.println("Before Merge: Managed with TransientField value of : " + managedBeforeMerge.getTransientField());
        DummyEntity managedAfterMerge = em.merge(managedBeforeMerge);
        System.out.println("After Merge: Managed with TransientField value of : " + managedAfterMerge.getTransientField());
    }

    @Transactional
    public void refreshBehaviour(){
        DummyEntity managedBeforeMerge = em.find(DummyEntity.class, 1l);
        managedBeforeMerge.setTransientField("transient");
        managedBeforeMerge.setName("Updated name");
        System.out.println("Before Refresh: Managed with TransientField value of : " + managedBeforeMerge.getTransientField());
        em.refresh(managedBeforeMerge);
        System.out.println("After Refresh : Managed with TransientField value of : " + managedBeforeMerge.getTransientField());
    }
}
