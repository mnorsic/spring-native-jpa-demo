package com.example.demo.service;

import com.example.demo.model.Foo;
import java.util.List;
import javax.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FooService {

	private final EntityManager entityManager;

	public List<Foo> findAll() {
		return entityManager.createQuery("SELECT f FROM Foo f", Foo.class).getResultList();
	}
}
