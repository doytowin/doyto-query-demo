/*
 * Copyright © 2019-2022 Forb Yuan
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package win.doyto.query.demo.module.menu;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * MenuControllerTest
 *
 * @author f0rb on 2021-12-05
 */
class MenuControllerTest {

    @Test
    void create() {
        MenuController menuController = new MenuController();

        MenuEntity menuEntity = new MenuEntity();
        menuEntity.setName("System");
        menuController.create(menuEntity);

        List<MenuEntity> list = menuController.query(new MenuQuery());

        assertThat(list)
                .first()
                .extracting("id", "name")
                .containsExactly(1, "System");
    }
}