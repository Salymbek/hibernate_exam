package hibernate.repository;

import hibernate.model.InstagramAccount;

public interface InstagramAccountsRepository {

    void saveInstagramAkk(InstagramAccount instagramAccount);
    InstagramAccount getInstagramById(Long instagramId);
    String deleteInstagramAkk(Long instagramId);
    InstagramAccount updateInstagramAkk(Long id , InstagramAccount instagramAccount);
    public Boolean existByEmail(String email);
    InstagramAccount changePassword(Long id, String password);


}
