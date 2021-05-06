package com.axelor.apps.mqtt.db.repo;

import com.axelor.apps.mqtt.db.TrashCan;

public class TrashRepo extends TrashCanRepository {
  @Override
  public TrashCan save(TrashCan entity) {

    System.err.println("hello world");

    return super.save(entity);
  }
}
