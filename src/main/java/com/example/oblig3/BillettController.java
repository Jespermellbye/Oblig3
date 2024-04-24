package com.example.oblig3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/billetter") // Base URL for klarhet og konsistens
public class BillettController {
    @Autowired
    private BillettRepository rep;

    @PostMapping("/lagre")
    public void lagreBillett(@RequestBody Billetter billett) {
        rep.lagreBillett(billett);
    }

    @GetMapping("/alle")
    public List<Billetter> hentAlleBilletter() {
        return rep.hentAlleBilletter();
    }

    @GetMapping("/{id}")
    public Billetter hentEnBillett(@PathVariable Integer id) {
        return rep.hentEnBillett(id);
    }

    @PutMapping("/rediger/{id}")
    public void redigerBillett(@PathVariable Integer id, @RequestBody Billetter billett) {
        billett.setId(id);
        rep.redigerBillett(billett);
    }

    @DeleteMapping("/slett/{id}")
    public void slettEnBillett(@PathVariable Integer id) {
        rep.slettEnBillett(id);
    }

    @DeleteMapping("/slettAlle")
    public void slettAlleBilletter() {
        rep.slettAlleBilletter();
    }
}

