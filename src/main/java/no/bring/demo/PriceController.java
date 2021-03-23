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

    private Logic logic = new Logic();

    @Autowired
    private PrisReopsitory prisRepository;

    @GetMapping("users")
    public List <PrisEntity> getUsers() {
        return this.prisRepository.findAll();
    }

    @RequestMapping(path = "sp", method = RequestMethod.GET)
    public int getSingleParcel(@RequestParam("weight") int weight,
                                @RequestParam("count") int count,
                                @RequestParam("prisid") long id)
    {
        PrisEntity price = this.prisRepository.findById(id);
        final int base = price.getBasePrice();
        final int packetp = price.getPacketPrice();
        final int weightp = price.getWeightPrice();

        return logic.singlePrice(base, packetp, count , weight, weightp);

    }
    @RequestMapping(path = "mp", method = RequestMethod.GET)
    public int[][] getMultipleParcels(@RequestParam("weight") int weight,
                                       @RequestParam("count") int count,
                                       @RequestParam("prisid") long id)
    {
        PrisEntity price = this.prisRepository.findById(id);
        final int base = price.getBasePrice();
        final int packetp = price.getPacketPrice();
        final int weightp = price.getWeightPrice();

        return logic.multiplePrice(base, packetp, count , weight, weightp);

    }
}
