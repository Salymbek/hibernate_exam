package hibernate.service.impl;

import hibernate.model.InstagramAccount;
import hibernate.repository.InstagramAccountsRepository;
import hibernate.repository.impl.InstagramAccountRepositoryImpl;
import hibernate.service.InstagramAccountService;

public class InstagramAccountsServiceImpl implements InstagramAccountService {

    InstagramAccountsRepository repository = new InstagramAccountRepositoryImpl();


    @Override
    public void saveInstagramAkk(InstagramAccount instagramAccount) {
        repository.saveInstagramAkk(instagramAccount);
    }

    @Override
    public InstagramAccount getInstagramById(Long instagramId) {

        return repository.getInstagramById(instagramId);

    }

    @Override
    public String deleteInstagramAkk(Long instagramId) {
        return repository.deleteInstagramAkk(instagramId);
    }

    @Override
    public InstagramAccount updateInstagramAkk(Long id, InstagramAccount instagramAccount) {
        return repository.updateInstagramAkk(id,instagramAccount);
    }

    @Override
    public Boolean existByEmail(String email) {
        return repository.existByEmail(email);
    }

    @Override
    public InstagramAccount changePassword(Long id, String password) {
        return repository.changePassword(id,password);
    }
}
