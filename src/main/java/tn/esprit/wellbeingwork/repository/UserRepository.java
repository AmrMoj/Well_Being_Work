package tn.esprit.wellbeingwork.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.wellbeingwork.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByEmail(String email);
	Boolean existsByEmail(String email);

	@Query(
			value = "SELECT p.theme FROM USER u " +
					"JOIN react r on r.user_react_id_user = u.id_user " +
					"JOIN post p on p.id_post = r.post_id_post " +
					"where u.id_user =?1 " +
					"GROUP BY p.theme, u.email " +
					"ORDER BY count(p.theme) " +
					"DESC LIMIT 2",
			nativeQuery = true)
	List<String> findFavouriteUserTheme(long idUser);
	
}
