package br.com.inthurn.VilaDevInHouse.service.restService.villageService;

import br.com.inthurn.VilaDevInHouse.dao.VillagerDAO;
import br.com.inthurn.VilaDevInHouse.model.entity.VillagerEntity;
import br.com.inthurn.VilaDevInHouse.model.transport.villager.VillagerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VillageService {

    @Autowired
    VillagerDAO villagerDAO;

    public List<VillagerDTO> listAll(){
        return villagerDAO
                .listAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public VillagerDTO listDetailsPerId(Integer id){
        return convertToDTO(villagerDAO.listDetailsPerId(id));
    }

    public void addNew(VillagerDTO villagerDTO){
        villagerDAO.addNew(villagerDTO);
    }


    public VillagerEntity convertToEntity(VillagerDTO villagerDTO){
            return new VillagerEntity(
                    villagerDTO.getName(),
                    villagerDTO.getSurname(),
                    villagerDTO.getBirthday(),
                    villagerDTO.getIncome(),
                    villagerDTO.getCpf()
            );

    }
    public VillagerDTO convertToDTO(VillagerEntity villagerEntity){
        return new VillagerDTO(
                villagerEntity.getName(),
                villagerEntity.getSurname(),
                villagerEntity.getBirthday(),
                villagerEntity.getIncome(),
                villagerEntity.getCpf()
        );
    }


}
