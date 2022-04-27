package com.example.demo.model;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FooRepository extends JpaRepository<Foo, Long> {

	@Query("select f from Foo f where f.value between :min and :max")
	List<Foo> findWithBetween(String min, String max);

	Foo findFirstByFlurbValueContaining(String name);
}
