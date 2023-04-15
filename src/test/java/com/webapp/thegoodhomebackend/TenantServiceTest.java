package com.webapp.thegoodhomebackend;

import com.webapp.thegoodhomebackend.entity.TenantEntity;
import com.webapp.thegoodhomebackend.repository.TenantRepository;
import com.webapp.thegoodhomebackend.service.TenantService;
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
public class TenantServiceTest {

    @Mock
    private TenantRepository tenantRepository;

    @InjectMocks
    private TenantService tenantService;

    // Test Add Tenant - POST Method //
    @Test
    public void testAddTenant() {
        TenantEntity tenantEntity = new TenantEntity(1, "Leon", "Chabanwood", "leonchabanwood", "8545825250");
        tenantService.createTenant(tenantEntity);
        verify(tenantRepository, times(1)).save(tenantEntity);
    }

    // Test Get Tenants - GET Method //
    @Test
    public void testGetTenants() {
        TenantEntity tenant1 = new TenantEntity(1, "Leon", "Chabanwood", "leonchabanwood@test.com", "8545825250");
        TenantEntity tenant2 = new TenantEntity(2, "Julius", "Chabawood", "julius@test.com", "9988776655");
        TenantEntity tenant3 = new TenantEntity(3, "Ugo", "Brun", "ugo@test.com", "1234567890");

        List<TenantEntity> tenantList = Arrays.asList(tenant1, tenant2, tenant3);

        when(tenantRepository.findAll()).thenReturn(tenantList);

        List<TenantEntity> result = tenantService.getTenants();

        assertEquals(3, result.size());
        assertTrue(result.contains(tenant1));
        assertTrue(result.contains(tenant2));
        assertTrue(result.contains(tenant3));
    }

    // Test Get Tenant by ID - GET Method //
    @Test
    public void testGetTenant() {
        TenantEntity tenantEntity = new TenantEntity(1L, "Leon", "Chabanwood", "leonchabanwood@test.com", "8545825250");

        when(tenantRepository.findById(1L)).thenReturn(Optional.of(tenantEntity));

        TenantEntity result = tenantService.getTenant(1L);

        assertEquals("Leon", result.getName());
        assertEquals("Chabanwood", result.getLastName());
        assertEquals("leonchabanwood@test.com", result.getEmail());
        assertEquals("8545825250", result.getPhone());
    }

    @Test
    public void testUpdateTenant() {
        TenantEntity tenantEntity = new TenantEntity(1L, "Leon", "Chabanwood", "leonchabanwood", "8545825250");

        when(tenantRepository.findById(1L)).thenReturn(Optional.of(tenantEntity));

        TenantEntity updatedTenant = new TenantEntity(1L, "Leon", "Chabanwood", "leonchabanwood", "1111111111");

        tenantService.updateTenant(1L, updatedTenant);

        verify(tenantRepository, times(1)).save(updatedTenant);
    }

    // Test Delete Tenant - DELETE Method //
    @Test
    public void testDeleteTenant() {
        TenantEntity tenantEntity = new TenantEntity(1L, "Leon", "Chabanwood", "leonchabanwood", "8545825250");

        when(tenantRepository.findById(1L)).thenReturn(Optional.of(tenantEntity));

        tenantService.deleteTenantById(1L);

        verify(tenantRepository, times(1)).deleteById(1L);
    }
}


