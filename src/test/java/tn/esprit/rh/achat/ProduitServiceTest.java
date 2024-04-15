package tn.esprit.rh.achat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.repositories.ProduitRepository;
import tn.esprit.rh.achat.repositories.StockRepository;
import tn.esprit.rh.achat.services.ProduitServiceImpl;

class ProduitServiceTest {
    @Mock
    ProduitRepository produitRepository;
    @Mock
    StockRepository stockRepository;
    @InjectMocks
    ProduitServiceImpl produitService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testRetrieveAllProduits() {
        Produit produit1 = new Produit();
        Produit produit2 = new Produit();
        List<Produit> produits = new ArrayList<>();

        produits.add(produit1);
        produits.add(produit2);

        when(produitRepository.findAll()).thenReturn(produits);
        List<Produit> result = produitService.retrieveAllProduits();
        assertEquals(2, result.size());
    }

    @Test
    void testAddProduit() {
        Produit produit = new Produit();

        when(produitRepository.save(produit)).thenReturn(produit);
        Produit result = produitService.addProduit(produit);
        assertEquals(produit, result);
    }

    @Test
    void testDeleteProduit() {
        Long productId = 1L;
        produitService.deleteProduit(productId);
        verify(produitRepository, times(1)).deleteById(productId);
    }

    @Test
    void testUpdateProduit() {
        Produit produit = new Produit();
        when(produitRepository.save(produit)).thenReturn(produit);
        Produit result = produitService.updateProduit(produit);
        assertEquals(produit, result);
    }

    @Test
    void testRetrieveProduit() {
        Long productId = 1L;
        Produit produit = new Produit();
        produit.setIdProduit(productId);
        when(produitRepository.findById(productId)).thenReturn(Optional.of(produit));
        Produit result = produitService.retrieveProduit(productId);
        assertEquals(productId, result.getIdProduit());
    }

    @Test
    void testAssignProduitToStock() {
        Long productId = 1L;
        Long stockId = 1L;

        Produit produit = new Produit();
        produit.setIdProduit(productId);

        Stock stock = new Stock();
        stock.setIdStock(stockId);

        when(produitRepository.findById(productId)).thenReturn(Optional.of(produit));
        when(stockRepository.findById(stockId)).thenReturn(Optional.of(stock));
        when(produitRepository.save(produit)).thenReturn(produit);

        produitService.assignProduitToStock(productId, stockId);

        assertEquals(stockId, produit.getStock().getIdStock());
    }
}

