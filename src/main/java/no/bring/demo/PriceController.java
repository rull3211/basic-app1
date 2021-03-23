package no.bring.demo;

import java.util.List;

import no.bring.demo.PrisEntity;
import no.bring.demo.PrisReopsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/")
public class PriceController {

    @Autowired
    private PrisReopsitory prisRepository;

    @GetMapping("users")
    public List < PrisEntity > getUsers() {
        return this.prisRepository.findAll();
    }

    @RequestMapping(path = "sp", method = RequestMethod.GET)
    public int getSingleParcel(@RequestParam("weight") int weight,
                        @RequestParam("count") int count,
                        @RequestParam("prisid") long id)
    {
        PrisEntity price = this.prisRepository.findById(id);
        final int base = price.getBasePrice();
        final int packet = price.getPacketPrice();
        final int weightp = price.getWeightPrice();
        int total = (weight*count * weightp) + (packet*count) + base;

        return total;

    }
    @RequestMapping(path = "mp", method = RequestMethod.GET)
    public int[][] getMultipleParcels(@RequestParam("weight") int weight,
                               @RequestParam("count") int count,
                               @RequestParam("prisid") long id)
    {
        PrisEntity price = this.prisRepository.findById(id);
        final int base = price.getBasePrice();
        final int packet = price.getPacketPrice();
        final int weightp = price.getWeightPrice();
        int[][] liste = new int[weight][count];
        for(int i = 0; i < weight; i++){
            for(int k = 0 ; k < count; k++){
                liste[i][k] = ((i+1)*(k+1) * weightp) + (packet*(k+1)) + base;
            }
        }
        return liste;

    }
}
