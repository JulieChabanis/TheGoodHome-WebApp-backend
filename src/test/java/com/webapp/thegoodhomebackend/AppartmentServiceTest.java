package com.webapp.thegoodhomebackend;

import com.webapp.thegoodhomebackend.entity.AppartmentEntity;
import com.webapp.thegoodhomebackend.repository.AppartmentRepository;
import com.webapp.thegoodhomebackend.service.AppartmentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AppartmentServiceTest {

    @Mock
    private AppartmentRepository appartmentRepository;

    @InjectMocks
    private AppartmentService appartmentService;

    // Test Add Appartment - POST Method //
    @Test
     void testAddAppartment() {
        AppartmentEntity appartmentEntity = new AppartmentEntity(1,"Title", "Description", "848 Wall Street", "740 Building Road", "New-York", "00001", 800, 100, 700, true);
        appartmentService.createAppartment(appartmentEntity);
        verify(appartmentRepository, times(1)).save(appartmentEntity);
    }

    // Test get Appartments - GET Method //
    @Test
     void testGetAppartments() {
        AppartmentEntity appartment1 = new AppartmentEntity(1,"Title", "Description", "700 Street Road", "3B Old Money", "New-York", "00001", 1300, 200, 1100, true);
        AppartmentEntity appartment2 = new AppartmentEntity(2,"Title", "Description", "118 Montague Saint", "Brooklyn", "New-York", "11201", 800, 100, 700, true);
        AppartmentEntity appartment3 = new AppartmentEntity(3,"Title", "Description", "54 Watts Saint", "Soho", "New-York", "10013", 2100, 200, 1900, true);

        List<AppartmentEntity> appartmentList = Arrays.asList(appartment1, appartment2, appartment3);

        when(appartmentRepository.findAll()).thenReturn(appartmentList);

        List<AppartmentEntity> result = appartmentService.getAppartments();

        assertEquals(3, result.size());
        assertTrue(result.contains(appartment1));
        assertTrue(result.contains(appartment2));
        assertTrue(result.contains(appartment3));

    }

    // Test Get Appartment by ID - GET Method //
    @Test
    void testGetAppartment() {
        AppartmentEntity appartmentEntity = new AppartmentEntity(3,"Title", "Description", "54 Watts Saint", "Soho", "New-York", "10013", 2100, 200, 1900, true);

        when(appartmentRepository.findById(1L)).thenReturn(Optional.of(appartmentEntity));

        AppartmentEntity result = appartmentService.getAppartment(1L);

        assertEquals("Title", result.getTitle());
        assertEquals("Description", result.getDescription());
        assertEquals("54 Watts Saint", result.getAddress());
        assertEquals("Soho", result.getAdditionalAddress());
        assertEquals("New-York", result.getCity());
        assertEquals("10013", result.getZipcode());
        assertEquals(2100, result.getRental());
        assertEquals(200, result.getRentalCharges());
        assertEquals(1900, result.getSecurityDeposit());
        assertEquals(true, result.isAvailable());
    }

    // Test update Appartment - PUT Methode //
    @Test
     void testUpdateAppartment() {
        AppartmentEntity appartmentEntity = new AppartmentEntity(3, "Title", "Description", "54 Watts Saint", "Soho", "New-York", "10013", 2100, 200, 1900, true);

        when(appartmentRepository.findById(1L)).thenReturn(Optional.of(appartmentEntity));

        AppartmentEntity updatedAppartment = new AppartmentEntity(3,"Title", "Description", "53 Watts Saint", "Soho", "New-York", "10013", 2100, 200, 1900, true);

        appartmentService.updateAppartment(1L, updatedAppartment);

        verify(appartmentRepository, times(1)).save(updatedAppartment);
    }

    // Test delete appartment - DELETE Method //
    @Test
    void testDeleteAppartment() {
        AppartmentEntity appartmentEntity = new AppartmentEntity(3,"Title", "Description", "54 Watts Saint", "Soho", "New-York", "10013", 2100, 200, 1900, true);

        when(appartmentRepository.findById(1L)).thenReturn(Optional.of(appartmentEntity));

        appartmentService.deleteAppartmentById(1L);

        verify(appartmentRepository, times(1)).deleteById(1L);
    }
}
