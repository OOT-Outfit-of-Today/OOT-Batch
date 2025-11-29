package com.ootbatch;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

/**
 * OotBatch 애플리케이션 테스트 클래스
 * 
 * 이 클래스는 Spring Boot 애플리케이션의 기본 테스트를 수행합니다.
 * @SpringBootTest: Spring Boot 테스트 컨텍스트를 로드하여 통합 테스트를 수행합니다.
 * @ActiveProfiles("test"): application-test.yml 프로파일을 활성화합니다.
 *   - 이 어노테이션이 없으면 테스트 환경 설정이 적용되지 않습니다!
 *   - 테스트용 데이터베이스(test_db), Redis 설정 등을 사용하려면 필수입니다.
 */
@SpringBootTest
@ActiveProfiles("test") // application-test.yml 프로파일 활성화
class OotBatchApplicationTests {

    /**
     * Spring 애플리케이션 컨텍스트 로드 테스트
     * 
     * 이 테스트는 Spring Boot 애플리케이션이 정상적으로 시작되는지 확인합니다.
     * - 모든 Bean이 올바르게 생성되는지 검증
     * - 데이터베이스 연결 가능 여부 확인
     * - Redis 연결 가능 여부 확인
     */
    @Test
    void contextLoads() {
        // 이 테스트가 통과하면 Spring 컨텍스트가 정상적으로 로드된 것입니다.
    }

}
