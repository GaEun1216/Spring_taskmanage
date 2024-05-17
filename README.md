- **Use Case Diagram 그려보기!**
    - Use Case Diagram이란 서비스(System)와 사용자(Actor)간의 상호작용을 다이어그램으로 표현한 것입니다.
    - 사용자 관점에서 개발하려는 서비스의 기능 및 요소들을 한눈에 확인할 수 있다는 장점이 있습니다.
    - 개발에 들어가기에 앞서 먼저 아래 요구사항을 토대로 Use Case Diagram을 그려보면서 서비스의 전체적인 흐름을 확인해보세요!
    
![유즈케이스](https://github.com/GaEun1216/Spring_taskmanage/assets/51986588/c0755604-6366-4eb6-b198-03c6c15cacb6)
    
- **API 명세서 작성하기!**
    - API 명세서란 API명, 요청 값(파라미터), 반환 값, 인증/인가 방식, 데이터 및 전달 형식 등 API를 정확하게 호출하고 그 결과를 명확하게 해석하는데 필요한 정보들을 일관된 형식으로 기술한 것을 의미합니다.
    

    
- **ERD 작성하기!**
    

    
    - Use Case Diagram과 API 명세 작성을 통해 서비스의 큰 흐름과 기능을 파악 하셨다면 이제는 기능을 구현하기 위해 필요한 데이터가 무엇인지 생각해봐야합니다.
        - 이때, 구현해야 할 서비스의 영역별로 필요한 데이터를 설계하고 각 영역간의 관계를 표현하는 방법이 있는데 이를 ERD라 부릅니다.
    - E(Entity. 개체)
        - 구현 할 서비스의 영역에서 필요로 하는 데이터를 담을 개체를 의미합니다.
            - ex) `책`, `저자`, `독자`, `리뷰`
    - A(Attribute. 속성)
        - 각 개체가 가지는 속성을 의미합니다.
            - ex) 책은 `제목`, `언어`, `출판일`, `저자`, `가격` 등의 속성을 가질 수 있습니다.
    - R(Relationship. 관계)
        - 개체들 사이의 관계를 정의합니다.
            - ex) `저자`는 여러 권의 `책`을 집필할 수 있습니다. 이때, 저자와 책의 관계는 일대다(1:N) 관계입니다.
    
![OMD (1)](https://github.com/GaEun1216/Spring_taskmanage/assets/51986588/8293ee6e-08ab-4462-9de6-47a5fe536e62)

    
- **API 테스트 하기!**
    - 과제를 진행 하시면서 여러분들이 개발한 API가 요구사항에 맞게 동작 하는지 확인하려면 API가 반환하는 반환(결과) 값을 계속해서 확인하셔야 합니다.



- *** 링크 첨부 ***
 
    https://documenter.getpostman.com/view/34881291/2sA3JT1xn8
  



