package at.fhtw.swen3.configuration;


import at.fhtw.swen3.services.ParcelService;
import at.fhtw.swen3.services.WarehouseService;
import at.fhtw.swen3.services.impl.ParcelServiceImpl;
import at.fhtw.swen3.services.impl.WarehouseServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ParcelService parcelService() {
        return new ParcelServiceImpl();
    }

    @Bean
    public WarehouseService warehouseService() {
        return new WarehouseServiceImpl();
    }


}
