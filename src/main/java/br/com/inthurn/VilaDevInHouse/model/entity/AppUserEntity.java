package br.com.inthurn.VilaDevInHouse.model.entity;

import br.com.inthurn.VilaDevInHouse.interfaces.AppEntity;
import br.com.inthurn.VilaDevInHouse.model.transport.appuser.AppUserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppUserEntity {

    private Integer id;
    private String username;
    private String password;
    private Integer role_id;

    public AppUserEntity(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
