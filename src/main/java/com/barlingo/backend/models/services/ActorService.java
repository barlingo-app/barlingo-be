package com.barlingo.backend.models.services;

import com.barlingo.backend.models.entities.Actor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ActorService {
  // TODO: Realizar la clase de UserAccountService
//	@Autowired
//	private UserAccountService userAccountService;
//	@Autowired
//	private ActorRepository actorRepository;

  public Actor findByPrincipal() {
    Actor result = null;
//		UserAccount userAccount;
//
//		try {
//			userAccount = LoginSecrvice.getPrincipal();
//			Assert.notNull(userAccount, "");
//			result = this.findByUserAccount(userAccount);
//			Assert.notNull(result, "");
//
//		} catch (final Exception e) {
//			e.printStackTrace();
//		}

    return result;
  }

//	public Actor findByUserAccount(final UserAccount userAccount) {
//		Assert.notNull(userAccount);
//
//		Actor result;
//
//		result = this.actorRepository.findByUserAccountId(userAccount.getId());
//		Assert.notNull(result, "");
//
//		return result;
//	}
}
