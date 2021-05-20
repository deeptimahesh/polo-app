package org.polo.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.polo.web.rest.TestUtil;

class AuthorDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(AuthorDTO.class);
        AuthorDTO authorDTO1 = new AuthorDTO();
        authorDTO1.setId("id1");
        AuthorDTO authorDTO2 = new AuthorDTO();
        assertThat(authorDTO1).isNotEqualTo(authorDTO2);
        authorDTO2.setId(authorDTO1.getId());
        assertThat(authorDTO1).isEqualTo(authorDTO2);
        authorDTO2.setId("id2");
        assertThat(authorDTO1).isNotEqualTo(authorDTO2);
        authorDTO1.setId(null);
        assertThat(authorDTO1).isNotEqualTo(authorDTO2);
    }
}
