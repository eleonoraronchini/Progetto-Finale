package ProgettoFInale.payload;

import ProgettoFInale.model.enumerations.APIStatus;

public record APIResponse<T>(
        APIStatus status,
        T data

) {
}
